package com.example.let_server.domain.eater.domain;

import com.example.let_server.domain.meal.domain.Meal;
import com.example.let_server.domain.user.domain.User;

public class Eater {
    private Long eaterId;
    private User user;
    private Meal meal;
    private boolean eaten;
    private int firstGradeTotalCnt;
    private int secondGradeTotalCnt;
    private int thirdGradeTotalCnt;
}
