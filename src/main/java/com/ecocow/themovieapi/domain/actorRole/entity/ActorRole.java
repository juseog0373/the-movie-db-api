package com.ecocow.themovieapi.domain.actorRole.entity;

import com.ecocow.themovieapi.common.base.AuditingEntity;
import com.ecocow.themovieapi.domain.actor.entity.Actor;
import com.ecocow.themovieapi.domain.movie.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table
public class ActorRole extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_role_id")
    private Long actorRoleId;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Comment("역할")
    @Column(name = "movie_character", nullable = false)
    private String character;
}
