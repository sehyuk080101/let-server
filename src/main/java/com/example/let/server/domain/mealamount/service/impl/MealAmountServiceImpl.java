package com.example.let.server.domain.mealamount.service.impl;

import com.example.let.server.domain.mealamount.domain.MealAmount;
import com.example.let.server.domain.mealamount.repository.MealAmountRepository;
import com.example.let.server.domain.mealamount.service.MealAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealAmountServiceImpl implements MealAmountService {
    private final MealAmountRepository mealAmountRepository;

    public void saveMealAmount(MealAmount mealAmount) {
        mealAmountRepository.save(mealAmount);
    }
}
