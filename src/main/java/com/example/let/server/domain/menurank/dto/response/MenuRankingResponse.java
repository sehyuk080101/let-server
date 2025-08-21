package com.example.let.server.domain.menurank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRankingResponse {
    private Long menuId;
    private String menuName;
    private double menuScore;
    private Integer currentRank;
}
