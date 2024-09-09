package com.ecocow.themovieapi.domain.movie;

import com.ecocow.themovieapi.common.dto.ResponseDto;
import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse;
import com.ecocow.themovieapi.domain.movie.dto.RecommendMoviesResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Movie", description = "영화 관련 API")
@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "영화 상세보기", description = "영화 ID를 파라미터로 받아 영화의 정보를 가져옵니다.")
    @GetMapping("/{movieId}")
    public ResponseEntity<ResponseDto<MovieDetailResponse>> findById(@Parameter(name = "movieId", description = "movie의 id") @PathVariable Long movieId) {

        MovieDetailResponse response = movieService.findById(movieId);

        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ResponseDto.<MovieDetailResponse>builder()
                            .result(false)
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("not found movie")
                            .build()
            );
        }

        return ResponseEntity.ok().body(
                ResponseDto.<MovieDetailResponse>builder()
                        .result(true)
                        .status(HttpStatus.OK.value())
                        .message("조회 완료")
                        .data(response)
                        .build()
        );
    }

    @Operation(summary = "관련 영화 추천", description = "영화 ID를 파라미터로 받아 해당 영화의 장르를 가져오고 관련 영화를 가져옵니다.")
    @GetMapping("/{movieId}/recommend")
    public ResponseEntity<ResponseDto<List<RecommendMoviesResponse>>> getRecommendedMovies(@Parameter(name = "movieId", description = "movie의 id") @PathVariable Long movieId) {
        List<RecommendMoviesResponse> recommendedMovies = movieService.getRecommendMovies(movieId);

        if (recommendedMovies == null || recommendedMovies.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ResponseDto.<List<RecommendMoviesResponse>>builder()
                            .result(false)
                            .status(HttpStatus.NOT_FOUND.value())
                            .message("not found recommend movie")
                            .build()
            );
        }

        return ResponseEntity.ok().body(
                ResponseDto.<List<RecommendMoviesResponse>>builder()
                        .result(true)
                        .status(HttpStatus.OK.value())
                        .message("추천 영화 조회 완료")
                        .data(recommendedMovies)
                        .build()
        );
    }
}
