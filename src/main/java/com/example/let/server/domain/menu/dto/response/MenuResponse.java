package com.example.let.server.domain.menu.dto.response;

import com.example.let.server.domain.menu.domain.Menu;
import lombok.*;

@Getter
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
