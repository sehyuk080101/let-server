package com.example.let_server.domain.menu.service;

import com.example.let_server.domain.menu.domain.Menu;
import com.example.let_server.domain.menu.error.MenuError;
import com.example.let_server.domain.menu.repository.MenuRepository;
import com.example.let_server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Menu findByMenuId(Long menuId) {
        return menuRepository.findByMenuId(menuId)
                .orElseThrow(() -> new CustomException(MenuError.MENU_NOT_FOUND));
    }

    public Optional<Menu> findByName(String menuName) {
        return menuRepository.findByName(menuName);
    }
}
