package com.example.let_server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class MonthlyStatisticsResponse {
    private int year;
    private int month;
    private Long totalStudents;
    private Map<Integer, Long> studentsByGrade;
    private Double averageParticipationRate;
    private Double averageRating;
    private Long totalMeals;
    private Double totalCaloriesProvided;
    private Double totalCaloriesConsumed;
    private List<String> topMenus;
    private List<String> leastPopularMenus;
}