package com.example.let.server.domain.menurank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPageResponse {
    private List<MenuRankingResponse> menus;
    private int total;
    private int page;
    private int size;

    public static MenuPageResponse of(List<MenuRankingResponse> menus, int total, int page, int size) {
        return MenuPageResponse.builder()
                .menus(menus)
                .total(total)
                .page(page)
                .size(size)
                .build();
    }
}
