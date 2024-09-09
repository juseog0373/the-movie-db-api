package com.ecocow.themovieapi.domain.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieCategory {

    ACT("액션"),
    COM("코미디"),
    DRM("드라마"),
    SF("SF"),
    ROM("로맨스"),
    THR("스릴러"),
    HOR("공포"),
    CRI("범죄"),
    ANI("애니메이션"),
    FAN("판타지"),
    ADV("모험"),
    DOC("다큐멘터리"),
    WAR("전쟁"),
    MUS("음악"),
    FAM("가족");

    private final String desc;
}
