package com.example.let.server.global.config.mybatis;

import com.example.let.server.domain.allergy.mapper.AllergyMapper;
import com.example.let.server.domain.allergy.repository.AllergyRepository;
import com.example.let.server.domain.allergy.repository.MybatisAllergyRepository;
import com.example.let.server.domain.eater.mapper.EaterMapper;
import com.example.let.server.domain.eater.repository.EaterRepository;
import com.example.let.server.domain.eater.repository.MybatisEaterRepository;
import com.example.let.server.domain.exercises.mapper.ExerciseMapper;
import com.example.let.server.domain.exercises.repository.ExerciseRepository;
import com.example.let.server.domain.exercises.repository.MybatisExerciseRepository;
import com.example.let.server.domain.meal.mapper.MealMapper;
import com.example.let.server.domain.meal.repository.MealRepository;
import com.example.let.server.domain.meal.repository.MybatisMealRepository;
import com.example.let.server.domain.mealmenu.mapper.MealMenuMapper;
import com.example.let.server.domain.mealmenu.repository.MealMenuRepository;
import com.example.let.server.domain.mealmenu.repository.MybatisMealMenuRepository;
import com.example.let.server.domain.mealrating.mapper.MealRatingMapper;
import com.example.let.server.domain.mealrating.repository.MealRatingRepository;
import com.example.let.server.domain.mealrating.repository.MybatisMealRatingRepository;
import com.example.let.server.domain.menu.mapper.MenuMapper;
import com.example.let.server.domain.menu.repository.MenuRepository;
import com.example.let.server.domain.menu.repository.MybatisMenuRepository;
import com.example.let.server.domain.menuallergy.mapper.MenuAllergyMapper;
import com.example.let.server.domain.menuallergy.repository.MenuAllergyRepository;
import com.example.let.server.domain.menuallergy.repository.MybatisMenuAllergyRepository;
import com.example.let.server.domain.menurank.mapper.MenuRankMapper;
import com.example.let.server.domain.menurank.repository.MenuRankRepository;
import com.example.let.server.domain.menurank.repository.MybatisMenuRankRepository;
import com.example.let.server.domain.user.mapper.UserMapper;
import com.example.let.server.domain.user.repository.MybatisUserRepository;
import com.example.let.server.domain.user.repository.UserRepository;
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
    private final EaterMapper eaterMapper;
    private final MenuRankMapper menuRankMapper;
    private final MealRatingMapper mealRatingMapper;
    private final ExerciseMapper exerciseMapper;

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

    @Bean
    public EaterRepository eaterRepository() {
        return new MybatisEaterRepository(eaterMapper);
    }

    @Bean
    public MenuRankRepository menuRankRepository() {
        return new MybatisMenuRankRepository(menuRankMapper);
    }

    @Bean
    public MealRatingRepository mealRatingRepository() {
        return new MybatisMealRatingRepository(mealRatingMapper);
    }

    @Bean
    public ExerciseRepository exerciseRepository() {return new MybatisExerciseRepository(exerciseMapper);
    }
}
