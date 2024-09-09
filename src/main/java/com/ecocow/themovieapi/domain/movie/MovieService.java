package com.ecocow.themovieapi.domain.movie;

import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse;
import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse.ActorDetail;
import com.ecocow.themovieapi.domain.movie.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieQueryRepository movieQueryRepository;

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
}
