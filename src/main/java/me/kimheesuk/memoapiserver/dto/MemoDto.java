package me.kimheesuk.memoapiserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.kimheesuk.memoapiserver.jpa.domain.Memo;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import sun.management.VMOptionCompositeData;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class MemoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private static ModelMapper modelMapper = new ModelMapper();

    private Long id;

    private String userId;

    private String userName;

    private String title;

    private String contents;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public static MemoDto convertMemoEntityToDto(Memo memo){
        return modelMapper.map(memo, MemoDto.class);
    }

    public static List<MemoDto> convertMemoEntityToDto(List<Memo> memo){
        return memo.stream()
                .map(MemoDto::convertMemoEntityToDto)
                .collect(Collectors.toList());
    }

    public static Memo convertMemoDtoToEntity(MemoDto memoDto){
        return modelMapper.map(memoDto, Memo.class);
    }
}
