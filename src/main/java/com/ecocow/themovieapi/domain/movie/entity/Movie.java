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

    @Comment("제목")
    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Comment("개봉일")
    @Column(name = "movie_release_date", nullable = false)
    private LocalDateTime movieReleaseDate;

    @Comment("카테고리")
    @Column(name = "movie_category")
    @Enumerated(EnumType.STRING)
    private MovieCategory movieCategory;

    @Comment("러닝타임")
    @Column(name = "running_time")
    private String runningTime;

    @Comment("회원점수(%)")
    @Column(name = "user_score_chart")
    private int userScoreChart;

    @Comment("영화 태그라인")
    @Column(name = "movie_tagline")
    private String movieTagline;

    @Comment("개요")
    @Column(name = "movie_over_view")
    private String movieOverView;

    @Comment("감독")
    @Column(name = "director")
    private String director;

    @Comment("각본")
    @Column(name = "screenplay")
    private String screenplay;
}
