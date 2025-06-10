package com.example.let_server.domain.eater.service.impl;

import com.example.let_server.domain.eater.domain.Eater;
import com.example.let_server.domain.eater.dto.response.EaterRatioResponse;
import com.example.let_server.domain.eater.dto.response.EaterResponse;
import com.example.let_server.domain.eater.error.EaterError;
import com.example.let_server.domain.eater.repository.EaterRepository;
import com.example.let_server.domain.eater.service.EaterService;
import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.meal.domain.MealType;
import com.example.let_server.domain.meal.service.MealService;
import com.example.let_server.domain.user.domain.User;
import com.example.let_server.domain.user.service.UserService;
import com.example.let_server.global.error.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EaterServiceImpl implements EaterService {
    private final MealService mealService;
    private final UserService userService;
    private final EaterRepository eaterRepository;

    @Scheduled(cron = "0 0 0,10,15 * * *")
    public void insertEater(){
        MealType currentMealType = getCurrentMealType();
        LocalDate localDate = LocalDate.now();
        Date currentDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Meal meal = mealService.getMealByMealTypeAndMealDate(currentMealType,currentDate);
        List<User> users = userService.findAllUser();

        for (User user : users) {
            Eater eater = Eater.builder()
                    .user(user)
                    .meal(meal)
                    .build();

            eaterRepository.save(eater);
        }
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
}
