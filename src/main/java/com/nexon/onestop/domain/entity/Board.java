package com.nexon.onestop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.EAGER )        // Many=board , User=Category
    @JoinColumn(name="category_id")              //board 테이블에 Category 테이블을 참조할 수 있는 FOREIGN KEY 자동으로 생성된다.
    private Category category;


}
