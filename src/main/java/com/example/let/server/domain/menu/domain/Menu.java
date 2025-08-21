package com.example.let.server.domain.menu.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Long menuId;
    private String menuName;
    private double menuScore;
    private Long likeCount;
    private Long dislikeCount;
    private int currentRank;
}
