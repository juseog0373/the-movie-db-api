package com.ecocow.themovieapi.domain.movie;

import com.ecocow.themovieapi.domain.actorRole.entity.QActorRole;
import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse;
import com.ecocow.themovieapi.domain.movie.dto.MovieDetailResponse.ActorDetail;
import com.ecocow.themovieapi.domain.movie.entity.Movie;
import com.ecocow.themovieapi.domain.movie.entity.QMovie;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.ecocow.themovieapi.domain.actor.entity.QActor.actor;
import static com.ecocow.themovieapi.domain.actorRole.entity.QActorRole.actorRole;
import static com.ecocow.themovieapi.domain.movie.entity.QMovie.movie;

@Repository
public class MovieQueryRepository {

    private final JPAQueryFactory query;

    public MovieQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    /**
     * 영화 정보를 가져오는 메서드
     * @param movieId
     * @return
     */
    public Movie findByMovieId(Long movieId) {
        return query.selectFrom(movie)
                .where(movie.movieId.eq(movieId))
                .fetchOne();
    }

    /**
     * 영화의 출연진 정보를 가져오는 메서드
     * @param movieId
     * @return
     */
    public List<ActorDetail> findActorsByMovieId(Long movieId) {
        return query.select(Projections.fields(
                        ActorDetail.class,
                        actor.name.as("name"),
                        actorRole.character.as("character")
                ))
                .from(actorRole)
                .leftJoin(actor).on(actorRole.actor.eq(actor))
                .where(actorRole.movie.movieId.eq(movieId))
                .fetch();
    }
}