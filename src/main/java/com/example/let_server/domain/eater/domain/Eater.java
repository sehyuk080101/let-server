package com.example.let_server.domain.eater.domain;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Eater {
    private Long eaterId;
    private User user;
    private Meal meal;
    private boolean eaten;
    private static int firstGradeTotalCnt;
    private static int secondGradeTotalCnt;
    private static int thirdGradeTotalCnt;
}
