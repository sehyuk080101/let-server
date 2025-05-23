package com.example.let_server.domain.menu.dto;

import com.example.let_server.domain.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {
    private Long menuId;
    private String menuName;

    public static MenuResponse of(Menu menu) {
        return MenuResponse.builder()
                .menuId(menu.getMenuId())
                .menuName(menu.getMenuName())
                .build();
    }
}
