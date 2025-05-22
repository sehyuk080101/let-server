package com.example.let_server.domain.menu.service;

import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu save(String menuName) {
        Menu menu = Menu.builder()
                .menuName(menuName)
                .likeCount(0L)
                .dislikeCount(0L)
                .build();
        return menuRepository.save(menu);
    }
}
