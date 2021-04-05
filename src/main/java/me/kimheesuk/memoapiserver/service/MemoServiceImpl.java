package me.kimheesuk.memoapiserver.service;

import lombok.RequiredArgsConstructor;
import me.kimheesuk.memoapiserver.dto.MemoDto;
import me.kimheesuk.memoapiserver.jpa.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService{
    private final MemoRepository memoRepository;

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
        setCurrentTime(memoDto);

        memoRepository.save(MemoDto.convertMemoDtoToEntity(memoDto));
    }

    @Override
    public void editMemo(MemoDto memoDto) {
        setCurrentTime(memoDto);

        memoRepository.setMemoByMemoId(memoDto.getId(), memoDto.getTitle(), memoDto.getContents(), LocalDateTime.now());
    }

    @Override
    public void deleteMemo(Long memoId) {
        memoRepository.deleteById(memoId);
    }

    public void setCurrentTime(MemoDto memoDto){
        LocalDateTime currentTime = LocalDateTime.now();

        memoDto.setCreateTime(currentTime);
        memoDto.setUpdateTime(currentTime);
    }

}
