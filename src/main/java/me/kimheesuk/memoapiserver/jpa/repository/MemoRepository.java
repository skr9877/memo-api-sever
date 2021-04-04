package me.kimheesuk.memoapiserver.jpa.repository;

import me.kimheesuk.memoapiserver.jpa.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAll();

    Memo findMemoById(Long Id);

    void deleteById(Long Id);

    @Modifying
    @Transactional
    @Query("update Memo m set m.title = ?2, m.contents = ?3, m.updateTime = ?4 WHERE m.id = ?1")
    void setMemoByMemoId(@Param("memoId") Long memoId, @Param("title") String title, @Param("contents") String contents, @Param("updateTime")LocalDateTime updateTime);
}