package me.kimheesuk.memoapiserver.controller;

import lombok.RequiredArgsConstructor;
import me.kimheesuk.memoapiserver.dto.MemoDto;
import me.kimheesuk.memoapiserver.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {
    private final MemoService memoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemoDto>> getMemoList(){
        return new ResponseEntity(memoService.getMemoList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{memoId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemoDto> getMemo(@PathVariable("memoId") Long memoId){
        return new ResponseEntity<>(memoService.getMemo(memoId), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addMemo(@RequestBody MemoDto memoDto){
        String message = "save success";

        memoService.addMemo(memoDto);

        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PutMapping(value = "/{memoId}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editMemo(@RequestBody MemoDto memoDto){
        String message = "edit success";

        memoService.editMemo(memoDto);

        return new ResponseEntity(message, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{memoId}")
    public ResponseEntity<String> deleteMemo(@PathVariable("memoId") Long memoId){
        String message = "delete success";

        memoService.deleteMemo(memoId);

        return new ResponseEntity(message, HttpStatus.OK);
    }


}
