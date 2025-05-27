package com.example.let_server.domain.menu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Menu {
    private Long menuId;
    private String menuName;
    private double menuScore;
    private Long likeCount;
    private Long dislikeCount;
    private int currentRank;
}
