package com.example.let.server.domain.statistics.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LowParticipationAnalysis {
    private Integer threshold;
    private String period;
    private Integer count;
    private List<LowParticipationMeal> lowParticipationMeals;
}
