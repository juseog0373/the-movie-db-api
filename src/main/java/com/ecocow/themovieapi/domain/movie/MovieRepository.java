package com.ecocow.themovieapi.domain.movie;

import com.ecocow.themovieapi.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
