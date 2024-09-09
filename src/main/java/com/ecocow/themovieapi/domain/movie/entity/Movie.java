package com.ecocow.themovieapi.domain.movie.entity;

import javax.persistence.*;

import com.ecocow.themovieapi.common.base.AuditingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "movie")
public class Movie extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long movieId;

    @Comment("제목")
    @Column(name = "title", nullable = false)
    private String title;

    @Comment("썸네일이미지")
    @Column(name = "movie_thumb_img")
    private String movieThumbImg;

    @Comment("개봉일")
    @Column(name = "movie_release_date", nullable = false)
    private LocalDateTime movieReleaseDate;

    @Comment("카테고리")
    @Column(name = "movie_category", nullable = false)
//    @Enumerated(EnumType.STRING)
    private String movieCategory;

    @Comment("러닝타임")
    @Column(name = "running_time", nullable = false)
    private String runningTime;

    @Comment("회원점수(%)")
    @Column(name = "user_score_chart", nullable = false)
    private int userScoreChart;

    @Comment("영화 태그라인")
    @Column(name = "movie_tagline", nullable = false)
    private String movieTagline;

    @Comment("개요")
    @Column(name = "movie_overview", nullable = false)
    @Lob
    private String movieOverview;

    @Comment("감독")
    @Column(name = "director", nullable = false)
    private String director;

    @Comment("각색")
    @Column(name = "screenplay")
    private String screenplay;

    @Comment("각본")
    @Column(name = "writer")
    private String writer;
}
