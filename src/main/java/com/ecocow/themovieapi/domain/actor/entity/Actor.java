package com.ecocow.themovieapi.domain.actor.entity;

import com.ecocow.themovieapi.common.base.AuditingEntity;
import com.ecocow.themovieapi.domain.movie.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "actor")
public class Actor extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private Long actorId;

    @Comment("이름")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("약력")
    @Column(name = "history", nullable = false)
    @Lob
    private String history;

    @Comment("성별")
    @Column(name = "gender", nullable = false)
    private String gender;

    @Comment("생일")
    @Column(name = "birthDay", nullable = false)
    private LocalDateTime birthDay;

    @Comment("출생지")
    @Column(name = "born", nullable = false)
    private String born;
}
