package me.kimheesuk.memoapiserver.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "memo_list")
public class Memo {
    @Id @GeneratedValue
    @Column(name = "memo_id")
    private Long id;

    private String userId;

    private String userName;

    private String title;

    private String contents;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
