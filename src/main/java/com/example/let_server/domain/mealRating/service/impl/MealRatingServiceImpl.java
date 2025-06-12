package com.example.let_server.domain.mealRating.service.impl;

import com.example.let_server.domain.mealRating.repository.MealRatingRepository;
import com.example.let_server.domain.mealRating.service.MealRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class MealRatingServiceImpl implements MealRatingService {

    private final MealRatingRepository mealRatingRepository;

    @Scheduled(cron = "0 0 0 * * *")
    private void updateMenuScoreByWilson() {
        mealRatingRepository.updateMenuScoreByWilson();
    }

}
