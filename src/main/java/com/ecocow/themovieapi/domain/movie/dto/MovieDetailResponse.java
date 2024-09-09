package com.ecocow.themovieapi.domain.movie.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDetailResponse {
    private String movieThumb; // 썸네일 이미지
    private String title; // 영화 제목
    private int releaseYear; // 개봉 연도
    private LocalDateTime movieReleaseDate; // 개봉 일자
    private String movieCategory; // 장르 카테고리
    private String runningTime; // 러닝타임
    private int userScoreChart; // 회원 점수 차트
    private String movieTagline; // 영화 한줄 소개
    private String movieOverview; // 개요
    private String director; // 감독
    private String screenplay; // 각색
    private String writer; // 작가
    private List<ActorDetail> actors; // 배우 리스트

    // 배우 정보 클래스 추가
    @Getter
    @NoArgsConstructor
    public static class ActorDetail {
        private String name;
        private String character;

        @Builder
        public ActorDetail(String name, String character) {
            this.name = name;
            this.character = character;
        }
    }
}
