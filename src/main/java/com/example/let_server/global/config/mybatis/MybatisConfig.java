package com.example.let_server.global.config.mybatis;

import com.example.let_server.domain.allergy.mapper.AllergyMapper;
import com.example.let_server.domain.allergy.repository.AllergyRepository;
import com.example.let_server.domain.allergy.repository.MybatisAllergyRepository;
import com.example.let_server.domain.meal.mapper.MealMapper;
import com.example.let_server.domain.meal.repositroy.MealRepository;
import com.example.let_server.domain.meal.repositroy.MybatisMealRepository;
import com.example.let_server.domain.mealMenu.mapper.MealMenuMapper;
import com.example.let_server.domain.mealMenu.repository.MealMenuRepository;
import com.example.let_server.domain.mealMenu.repository.MybatisMealMenuRepository;
import com.example.let_server.domain.menu.mapper.MenuMapper;
import com.example.let_server.domain.menu.repository.MenuRepository;
import com.example.let_server.domain.menu.repository.MybatisMenuRepository;
import com.example.let_server.domain.menuAllergy.mapper.MenuAllergyMapper;
import com.example.let_server.domain.menuAllergy.repository.MenuAllergyRepository;
import com.example.let_server.domain.menuAllergy.repository.MybatisMenuAllergyRepository;
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
    private final MenuAllergyMapper menuAllergyMapper;
    private final AllergyMapper allergyMapper;

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

    @Bean
    public AllergyRepository allergyRepository() {
        return new MybatisAllergyRepository(allergyMapper);
    }

    @Bean
    public MenuAllergyRepository menuAllergyRepository() {
        return new MybatisMenuAllergyRepository(menuAllergyMapper);
    }

}
