package com.example.let_server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LowParticipationAnalysis {
    private Integer threshold;
    private String period;
    private Integer count;
    private List<LowParticipationMeal> lowParticipationMeals;
}