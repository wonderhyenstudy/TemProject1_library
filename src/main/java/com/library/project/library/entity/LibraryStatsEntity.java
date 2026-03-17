package com.library.project.library.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "library_stats") // DB의 실제 테이블 이름과 연결
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LibraryStatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statId; // 통계 번호 (PK)

    @Column(length = 100, nullable = false)
    private String categoryName; // 자료 카테고리 (일반도서 등)

    @Column(nullable = false)
    private int itemCount; // 보유 수량
}
