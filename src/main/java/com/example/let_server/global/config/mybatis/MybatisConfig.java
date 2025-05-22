package com.example.let_server.global.config.mybatis;

import com.example.let_server.domain.meal.mapper.MealMapper;
import com.example.let_server.domain.meal.repositroy.MealRepository;
import com.example.let_server.domain.meal.repositroy.MybatisMealRepository;
import com.example.let_server.domain.mealMenu.mapper.MealMenuMapper;
import com.example.let_server.domain.mealMenu.repository.MealMenuRepository;
import com.example.let_server.domain.mealMenu.repository.MybatisMealMenuRepository;
import com.example.let_server.domain.menu.mapper.MenuMapper;
import com.example.let_server.domain.menu.repository.MenuRepository;
import com.example.let_server.domain.menu.repository.MybatisMenuRepository;
import com.example.let_server.domain.user.mapper.UserMapper;
import com.example.let_server.domain.user.repository.MybatisUserRepository;
import com.example.let_server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class MybatisConfig {
    private final UserMapper userMapper;
    private final MealMapper mealMapper;
    private final MenuMapper menuMapper;
    private final MealMenuMapper mealMenuMapper;

    @Bean
    public UserRepository userRepository() {
        return new MybatisUserRepository(userMapper);
    }
    @Bean
    public MealRepository mealRepository() {
        return new MybatisMealRepository(mealMapper);
    }
    @Bean
    public MenuRepository menuRepository() {
        return new MybatisMenuRepository(menuMapper);
    }
    @Bean
    public MealMenuRepository mealMenuRepository() {
        return new MybatisMealMenuRepository(mealMenuMapper);
    }
}
