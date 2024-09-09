package com.ecocow.themovieapi.domain.movie;

import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse;
import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse.ActorDetail;
import com.ecocow.themovieapi.domain.movie.dto.RecommendMoviesResponse;
import com.ecocow.themovieapi.domain.movie.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieQueryRepository movieQueryRepository;
    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public MovieDetailResponse findById(Long movieId) {
        Movie findMovie = movieQueryRepository.findByMovieId(movieId);

        if (findMovie == null) {
            return null;
        }

        List<ActorDetail> actors = movieQueryRepository.findActorsByMovieId(findMovie.getMovieId());

        return MovieDetailResponse.builder()
                .movieThumb(findMovie.getMovieThumbImg())
                .title(findMovie.getTitle())
                .movieReleaseDate(findMovie.getMovieReleaseDate())
                .releaseYear(findMovie.getMovieReleaseDate().getYear())
                .movieCategory(findMovie.getMovieCategory())
                .runningTime(findMovie.getRunningTime())
                .userScoreChart(findMovie.getUserScoreChart())
                .movieTagline(findMovie.getMovieTagline())
                .movieOverview(findMovie.getMovieOverview())
                .director(findMovie.getDirector())
                .screenplay(findMovie.getScreenplay())
                .writer(findMovie.getWriter())
                .actors(actors)
                .build();
    }

    public List<RecommendMoviesResponse> getRecommendMovies(Long movieId) {
        Movie findMovie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalArgumentException("not found movie id"));
        if (findMovie == null) {
            return null;
        }

        List<String> categories = Arrays.asList(findMovie.getMovieCategory().split(","));
        for (String category : categories) {
            System.out.println(category);
        }
        List<Movie> recommendedMovies = movieQueryRepository.findRecommendMovies(categories, movieId);

        return recommendedMovies.stream()
                .map(recommendedMovie -> RecommendMoviesResponse.builder()
                        .movieId(recommendedMovie.getMovieId())
                        .title(recommendedMovie.getTitle())
                        .build())
                .collect(Collectors.toList());
    }
}
