package com.example.let.server.domain.user.service.impl;

import com.example.let.server.domain.eater.domain.Eater;
import com.example.let.server.domain.eater.repository.EaterRepository;
import com.example.let.server.domain.meal.domain.Meal;
import com.example.let.server.domain.meal.domain.MealType;
import com.example.let.server.domain.meal.service.MealService;
import com.example.let.server.domain.user.domain.User;
import com.example.let.server.domain.user.dto.response.UserInfoResponse;
import com.example.let.server.domain.user.repository.UserRepository;
import com.example.let.server.domain.user.service.UserService;
import com.example.let.server.global.security.holder.SecurityHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SecurityHolder securityHolder;
    private final MealService mealService;
    private final EaterRepository eaterRepository;

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

    private boolean isEaten(){
        try {
            Meal meal = getCurrentMeal();
            User currentUser = securityHolder.getUser();
            Optional<Eater> eaterOpt = eaterRepository.findByUserIdAndMealId(currentUser.getUserId(), meal.getMealId());
            return eaterOpt.isPresent() && eaterOpt.get().isEaten();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserInfoResponse getMe() {
        User currentUser = securityHolder.getUser();
        Boolean isAttend = isEaten();
        return UserInfoResponse.of(currentUser, isAttend);
    }

    @Override
    public Long getTotalUserCount() {
        return userRepository.count();
    }

    @Override
    public Map<Integer, Long> getUserCountByGrade() {
        return userRepository.countByGrade();
    }
}
