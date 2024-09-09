package com.ecocow.themovieapi.domain.movie;

import com.ecocow.themovieapi.common.dto.ResponseDto;
import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public ResponseEntity<ResponseDto<MovieDetailResponse>> findById(@PathVariable Long movieId) {

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
}
