package com.example.let.server.domain.eater.service.impl;

import com.example.let.server.domain.eater.domain.Eater;
import com.example.let.server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let.server.domain.eater.dto.response.EaterResponse;
import com.example.let.server.domain.eater.dto.response.UserCalorieResponse;
import com.example.let.server.domain.eater.error.EaterError;
import com.example.let.server.domain.eater.repository.EaterRepository;
import com.example.let.server.domain.eater.service.EaterService;
import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.meal.domain.MealType;
import com.example.let.server.domain.meal.service.MealService;
import com.example.let.server.domain.user.domain.User;
import com.example.let.server.domain.user.service.UserService;
import com.example.let.server.global.error.CustomException;
import com.example.let.server.global.security.holder.SecurityHolder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EaterServiceImpl implements EaterService {
    private final MealService mealService;
    private final UserService userService;
    private final EaterRepository eaterRepository;
    private final SecurityHolder securityHolder;

    @Scheduled(cron = "0 0 0,10,15 * * *")
    @PostConstruct
    public void insertEater(){
        try {
            Meal meal = getCurrentMeal();
            List<User> users = userService.findAllUser();

            List<Eater> eaters = users.stream()
                    .map(user -> Eater.builder()
                            .user(user)
                            .meal(meal)
                            .build())
                    .toList();

            eaterRepository.saveAll(eaters);
        } catch (CustomException e) {
            // 급식 정보가 없는 경우 (주말, 휴일 등) 무시하고 계속 진행
        }
    }

    private Meal getCurrentMeal(){
        MealType currentMealType = getCurrentMealType();
        LocalDate localDate = LocalDate.now();
        Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return mealService.getMealByMealTypeAndMealDate(currentMealType,currentDate);
    }

    private MealType getCurrentMealType(){
        int hour = LocalDateTime.now().getHour();

        if (hour < 10) {
            return MealType.조식;
        } else if (hour < 15) {
            return MealType.중식;
        } else {
            return MealType.석식;
        }
    }

    @Override
    public List<EaterResponse> findByGrade(Long grade) {
        if (grade == null || grade < 1 || grade > 3) {
            throw new CustomException(EaterError.INVALID_GRADE);
        }

        return eaterRepository.findByGrade(grade).stream()
                .map(EaterResponse::of).toList();
    }

    @Override
    public List<EaterRatioResponse> getEaterRation(String mealType) {
        LocalDate localDate = LocalDate.now();
        Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return eaterRepository.getEaterRation(mealType,currentDate);
    }

    @Override
    public Integer getNotEaterCount() {
        LocalDate localDate = LocalDate.now();
        MealType currentMealType = getCurrentMealType();
        Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return eaterRepository.getNotEaterCount(currentMealType,currentDate);
    }

    @Override
    public List<EaterRatioResponse> getEaterRationMonthly() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        MealType currentMealType = getCurrentMealType();
        return eaterRepository.getEaterRationMonthly(currentMealType,year,month);
    }

    @Override
    public List<EaterRatioResponse> getAllEaterRationMonthly() {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        return eaterRepository.getAllEaterRationMonthly(year, month);
    }

    @Override
    public UserCalorieResponse getUserCalorieIntake(Long userId, LocalDate date) {
        Date dateForQuery = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        List<Meal> mealsForDate = mealService.getMealsByDate(dateForQuery);
        List<UserCalorieResponse.MealCalorieInfo> mealCalorieInfos = new ArrayList<>();
        double totalCalories = 0.0;
        
        for (Meal meal : mealsForDate) {
            Optional<Eater> eaterOpt = eaterRepository.findByUserIdAndMealId(userId, meal.getMealId());
            boolean eaten = eaterOpt.isPresent() && eaterOpt.get().isEaten();
            double mealCalories = eaten ? meal.getCalorie() : 0.0;
            
            mealCalorieInfos.add(UserCalorieResponse.MealCalorieInfo.builder()
                    .mealType(meal.getMealType().name())
                    .calories(mealCalories)
                    .eaten(eaten)
                    .build());
                    
            totalCalories += mealCalories;
        }
        
        return UserCalorieResponse.builder()
                .userId(userId)
                .date(date)
                .totalCalorieIntake(totalCalories)
                .meals(mealCalorieInfos)
                .build();
    }

    @Override
    public Double getMonthlyParticipationRate(int year, int month) {
        return eaterRepository.getMonthlyParticipationRate(year, month);
    }

    @Override
    public Double getMonthlyTotalCaloriesConsumed(int year, int month) {
        return eaterRepository.getMonthlyTotalCaloriesConsumed(year, month);
    }

    @Override
    public void registerEater() {
        Meal meal = getCurrentMeal();
        User currentUser = securityHolder.getUser();
        Eater eater = eaterRepository.findByUserIdAndMealId(currentUser.getUserId(),meal.getMealId())
                .orElseThrow(()->new CustomException(EaterError.EATER_NOT_FOUND));
        eaterRepository.registerEater(eater.getEaterId());
    }
}
